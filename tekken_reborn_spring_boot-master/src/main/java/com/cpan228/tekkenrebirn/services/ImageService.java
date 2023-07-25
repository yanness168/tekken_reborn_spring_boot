package com.cpan228.tekkenrebirn.services;

import com.cpan228.tekkenrebirn.model.Image;
import com.cpan228.tekkenrebirn.repository.ImageRepository;
import org.springframework.stereotype.Service;
@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image get(Integer id) {
        return imageRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        imageRepository.deleteById(id);
    }

    public Image save(String filename, String contentType, byte[] bytes) {
        Image image = new Image();
        image.setFilename(filename);
        image.setContentType(contentType);
        image.setContent(bytes);
        return imageRepository.save(image);
    }

    public Iterable<Image> getAllImages() {
        return imageRepository.findAll();
    }
}

