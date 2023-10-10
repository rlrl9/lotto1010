package com.example.springlab.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LottoDTO {
    private int lottoNum;
    private String result;
    private String imgName;
    private int countNum=0;
    public void countN(){countNum+=1;}
}
