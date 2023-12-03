package si.ape.parcel.models.converters;

import si.ape.parcel.lib.ImageMetadata;
import si.ape.parcel.models.entities.ParcelEntity;

public class ImageMetadataConverter {

    public static ImageMetadata toDto(ParcelEntity entity) {

        ImageMetadata dto = new ImageMetadata();
        dto.setImageId(entity.getId());
        dto.setCreated(entity.getCreated());
        dto.setDescription(entity.getDescription());
        dto.setTitle(entity.getTitle());
        dto.setHeight(entity.getHeight());
        dto.setWidth(entity.getWidth());
        dto.setUri(entity.getUri());

        return dto;

    }

    public static ParcelEntity toEntity(ImageMetadata dto) {

        ParcelEntity entity = new ParcelEntity();
        entity.setCreated(dto.getCreated());
        entity.setDescription(dto.getDescription());
        entity.setTitle(dto.getTitle());
        entity.setHeight(dto.getHeight());
        entity.setWidth(dto.getWidth());
        entity.setUri(dto.getUri());

        return entity;

    }

}
