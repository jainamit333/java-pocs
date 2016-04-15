package com.amit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by amit on 15/4/16.
 */
@Controller
public class ViewController {


    @RequestMapping("view")
    public String simpleView(){
        return "test";
    }

}
