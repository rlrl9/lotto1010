package com.example.springlab.controller;

import com.example.springlab.domain.LottoDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Random;

@Controller
@SessionAttributes("lotto1")
public class lottoController {
    @ModelAttribute("lotto1")
    public LottoDTO lottoMethod() {
        return new LottoDTO();
    }
    @GetMapping("/lotto")
    public String proc(@ModelAttribute("lotto1") LottoDTO dto, HttpServletRequest req, Model model) {
        Random rand = new Random();
        int num=rand.nextInt(6)+1;

        if(dto.getCountNum()>=3){
            dto.setResult("로또 응모는 낙첨한 경우에 한하여 3번까지만 가능합니다.<br>브라우저를 재기동한 후에 응모해주세요.");
            dto.setImgName("snow");
            model.addAttribute("refinfo", null);
        }
        else if(num==dto.getLottoNum()){
            dto.setResult("추카추카!!");
            dto.setImgName("sun");
            System.out.println(dto.getCountNum());
        }
        else{
            dto.setResult("아쉽네요 .. 다음 기회를 !!");
            model.addAttribute("refinfo", req.getHeader("referer"));
            dto.setImgName("rain");
            dto.countN();
            System.out.println(dto.getCountNum());
        }
        return "lottoView";
    }
}
