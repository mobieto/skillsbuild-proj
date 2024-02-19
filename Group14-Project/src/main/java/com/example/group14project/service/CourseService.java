package com.example.group14project.service;

import jakarta.annotation.PostConstruct;
import com.example.group14project.domain.Course;
import com.example.group14project.repo.CourseRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @PostConstruct
    public void scrapeAndSyncOnStartup() {
        scrapeAndSync();
    }

    public void scrapeAndSync() {
        String url = "https://skillsbuild.org/students/course-catalog";
        String selector1 = ".sb--col-lg-1\\/3.bx--col-md-4.md\\:pl-0.px-4.mb-4";
        String selector2 = ".sb--col-lg-1\\/3.bx--col-md-4.lg\\:-ml-4.mb-4";
        String selector3 = ".bx--expressive-heading-03.text-gray-100.mb-12";
        String prefix = "https://skillsbuild.org";
        List<Course> courses = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url).get();
            Elements options = document.select(selector1);



            for (Element option:options) {
                String linkHref = option.select("a").attr("href");
                Elements category = option.select(selector3);
                if (!linkHref.isEmpty()) {
                    String url2 = prefix + linkHref;
                    Document document2 = Jsoup.connect(url2).get();
                    Elements options2 = document2.select(selector2);

                    for (Element option2:options2) {
                        Elements name = option2.select(selector3);
                        String linkHref2 = option2.select("a").attr("href");
                        courses.add(new Course(name.text(),linkHref2, category.text()));
                    }
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }

        for (Course course: courses) {
            Course existingCourse = courseRepository.findByName(course.getName());

            if (existingCourse != null) {
                existingCourse.setLink(course.getLink());
                existingCourse.setCategory(course.getCategory());
                courseRepository.save(existingCourse);
            } else {
                courseRepository.save(course);
            }
        }
    }

}