package com.example.controller;

import com.example.dto.MusicDto;
import com.example.model.Music;
import com.example.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;
    @GetMapping("/")
    public String showList(Model model){
        model.addAttribute("musicList",iMusicService.findAll());
        return "list";
    }
    @GetMapping("/showCreate")
    public String showCreate(Model model){
        model.addAttribute("musicDto",new MusicDto());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute @Valid MusicDto musicDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("musicDto",musicDto);
            return "create";
        }
        Music music=new Music();
        BeanUtils.copyProperties(musicDto,music);
        this.iMusicService.save(music);
        redirectAttributes.addFlashAttribute("msg","Thêm mới thành công !");
        return "redirect:/";
    }
    @GetMapping("/showUpdate")
    public String showUpdate(@RequestParam Integer id, Model model){
        model.addAttribute("musicDto",iMusicService.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute @Valid MusicDto musicDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "update";
        }
        Music music=new Music();
        BeanUtils.copyProperties(musicDto,music);
        this.iMusicService.update(music);
        redirectAttributes.addFlashAttribute("msg","Chỉnh sửa thành công");
        return "redirect:/";
    }
}
