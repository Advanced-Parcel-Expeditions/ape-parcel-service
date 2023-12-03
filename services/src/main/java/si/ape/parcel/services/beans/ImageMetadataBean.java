package si.ape.parcel.services.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;

import si.ape.parcel.lib.ImageMetadata;
import si.ape.parcel.models.converters.ImageMetadataConverter;
import si.ape.parcel.models.entities.ParcelEntity;


@RequestScoped
public class ImageMetadataBean {

    private Logger log = Logger.getLogger(ImageMetadataBean.class.getName());

    @Inject
    private EntityManager em;

    public List<ImageMetadata> getImageMetadata() {

        TypedQuery<ParcelEntity> query = em.createNamedQuery(
                "ImageMetadataEntity.getAll", ParcelEntity.class);

        List<ParcelEntity> resultList = query.getResultList();

        return resultList.stream().map(ImageMetadataConverter::toDto).collect(Collectors.toList());

    }

    public List<ImageMetadata> getImageMetadataFilter(UriInfo uriInfo) {

        QueryParameters queryParameters = QueryParameters.query(uriInfo.getRequestUri().getQuery()).defaultOffset(0)
                .build();

        return JPAUtils.queryEntities(em, ParcelEntity.class, queryParameters).stream()
                .map(ImageMetadataConverter::toDto).collect(Collectors.toList());
    }

    public ImageMetadata getImageMetadata(Integer id) {

        ParcelEntity imageMetadataEntity = em.find(ParcelEntity.class, id);

        if (imageMetadataEntity == null) {
            throw new NotFoundException();
        }

        ImageMetadata imageMetadata = ImageMetadataConverter.toDto(imageMetadataEntity);

        return imageMetadata;
    }

    public ImageMetadata createImageMetadata(ImageMetadata imageMetadata) {

        ParcelEntity imageMetadataEntity = ImageMetadataConverter.toEntity(imageMetadata);

        try {
            beginTx();
            em.persist(imageMetadataEntity);
            commitTx();
        }
        catch (Exception e) {
            rollbackTx();
        }

        if (imageMetadataEntity.getId() == null) {
            throw new RuntimeException("Entity was not persisted");
        }

        return ImageMetadataConverter.toDto(imageMetadataEntity);
    }

    public ImageMetadata putImageMetadata(Integer id, ImageMetadata imageMetadata) {

        ParcelEntity c = em.find(ParcelEntity.class, id);

        if (c == null) {
            return null;
        }

        ParcelEntity updatedImageMetadataEntity = ImageMetadataConverter.toEntity(imageMetadata);

        try {
            beginTx();
            updatedImageMetadataEntity.setId(c.getId());
            updatedImageMetadataEntity = em.merge(updatedImageMetadataEntity);
            commitTx();
        }
        catch (Exception e) {
            rollbackTx();
        }

        return ImageMetadataConverter.toDto(updatedImageMetadataEntity);
    }

    public boolean deleteImageMetadata(Integer id) {

        ParcelEntity imageMetadata = em.find(ParcelEntity.class, id);

        if (imageMetadata != null) {
            try {
                beginTx();
                em.remove(imageMetadata);
                commitTx();
            }
            catch (Exception e) {
                rollbackTx();
            }
        }
        else {
            return false;
        }

        return true;
    }

    private void beginTx() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }

    private void commitTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    private void rollbackTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }
}
