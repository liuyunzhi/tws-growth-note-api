package cn.thoughtworks.school.growthnoteapi.controller;

import cn.thoughtworks.school.growthnoteapi.entity.Diary;
import cn.thoughtworks.school.growthnoteapi.exception.DiaryNotFoundException;
import cn.thoughtworks.school.growthnoteapi.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.text.ParseException;

@RestController
@RequestMapping("/diaries")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @PostMapping
    public ResponseEntity add(@RequestBody Diary diary) {
        return ResponseEntity.created(URI.create("/diaries/" + diaryService.add(diary))).build();
    }

    @GetMapping
    public ResponseEntity<Page<Diary>> getAll(@RequestParam(defaultValue = "0") Integer page,
                                       @RequestParam(defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(diaryService.getAll(page, pageSize));
    }

    @PutMapping("/{diaryId}")
    public ResponseEntity update(@PathVariable Long diaryId, @RequestBody Diary diary) throws ParseException {
        diaryService.update(diaryId, diary);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{diaryId}")
    public ResponseEntity remove(@PathVariable Long diaryId) {
        diaryService.remove(diaryId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    private void exceptionHandler(DiaryNotFoundException exception) {
    }
}
