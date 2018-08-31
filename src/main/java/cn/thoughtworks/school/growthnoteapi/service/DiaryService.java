package cn.thoughtworks.school.growthnoteapi.service;

import cn.thoughtworks.school.growthnoteapi.controller.response.DiariesResponse;
import cn.thoughtworks.school.growthnoteapi.entity.Diary;
import cn.thoughtworks.school.growthnoteapi.exception.DiaryNotFoundException;
import cn.thoughtworks.school.growthnoteapi.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    public Long add(Diary diary) {
        return diaryRepository.save(diary).getId();
    }

    public DiariesResponse getAll(Integer page, Integer pageSize) {
        Page<Diary> diaryPage = diaryRepository.findAll(PageRequest.of(page, pageSize));
        return new DiariesResponse(diaryPage.getTotalElements(),
                diaryPage.getNumber(),
                diaryPage.getSize(),
                diaryPage.getContent());
    }

    public void update(Long diaryId, Diary diary) {
        Diary oldDiary = diaryRepository.findById(diaryId).orElseThrow(DiaryNotFoundException::new);
        oldDiary.setDate(diary.getDate());
        oldDiary.setContent(diary.getContent());
        diaryRepository.save(oldDiary);
    }


    public void remove(Long diaryId) {
        Diary diary = diaryRepository.findById(diaryId).orElseThrow(DiaryNotFoundException::new);
        diaryRepository.delete(diary);
    }
}
