package com.example.controller;

import com.example.model.Music;
import com.example.model.MusicForm;
import com.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("/")
    public String showList(Model model) {
        List<Music> musicList = iMusicService.findAll();
        model.addAttribute("musicList", musicList);
        return "list";
    }

    @GetMapping("/form")
    public String showCreate(Model model) {
        model.addAttribute("musicForm", new MusicForm());
        return "form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute MusicForm musicForm, Model model) {
        MultipartFile multipartFile = musicForm.getMusic();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getMusic().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music = new Music(musicForm.getName(), musicForm.getSinger(), musicForm.getType(), fileName);
        iMusicService.save(music);
        model.addAttribute("mess", "Thêm mới thành công");
        model.addAttribute("musicList", this.iMusicService.findAll());
        return "list";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam int id, Model model) {
        Music music =iMusicService.findById(id);
        MusicForm musicForm=new MusicForm(music.getId(), music.getName(), music.getSinger(), music.getType(), music.getPath());
        model.addAttribute("musicForm", musicForm);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Music music, RedirectAttributes redirectAttributes) {
        this.iMusicService.update(music);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        iMusicService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/";
    }
}
