package com.merck.catalog.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
  * @FileName : BlogController.java
  * @Project : digital-catalog-app
  * @Date : 2021. 7. 10
  * @작성자 : softlab-hum.dev
  * @변경이력 :
  * @프로그램 설명 : 
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    /**
     * 
      * @Method Name : showPage
      * @작성일 : 2021.7. 10
      * @작성자 : softlab-hum.dev
      * @변경이력 : 
      * @Method 설명 :
      * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showPage(){
        return "blog";
    }

}
