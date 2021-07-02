package com.gs52.controller.schedule;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/schedule")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProjectListController {

}
