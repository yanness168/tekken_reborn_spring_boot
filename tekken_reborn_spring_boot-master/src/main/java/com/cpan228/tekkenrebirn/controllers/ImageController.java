package com.cpan228.tekkenrebirn.controllers;
import com.cpan228.tekkenrebirn.model.Image;
import com.cpan228.tekkenrebirn.model.ImageDto;
import com.cpan228.tekkenrebirn.services.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ImageController {
    private  final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/images")
    public String getImages(Model model) {
        Iterable<Image> images = imageService.getAllImages();
        List<ImageDto> imageDtos = new ArrayList<>();
        for (Image image : images) {
            imageDtos.add(new ImageDto(image.getId(), image.getFileName(), image.getContentType(), image.getData()));
        }
        model.addAttribute("images", imageDtos);
        return "display_images";
    }

    @PostMapping("/images/delete/{id}")
    public String deleteImage(@PathVariable Integer id){
        imageService.remove(id);
        return "redirect:/images";
    }

    @PostMapping("/upload_image")
    public String createImage(@RequestPart("data") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        imageService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        redirectAttributes.addFlashAttribute("message", "Image uploaded successfully!");
        return "redirect:/images";
    }


    @GetMapping("/upload_image")
    public String getUploadPage(Model model) {
        model.addAttribute("image", new Image());
        return "upload_image";
    }
}
