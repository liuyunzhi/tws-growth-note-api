package cn.thoughtworks.school.growthnoteapi.service;

import cn.thoughtworks.school.growthnoteapi.entity.Diary;
import cn.thoughtworks.school.growthnoteapi.exception.DiaryNotFoundException;
import cn.thoughtworks.school.growthnoteapi.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    public Long add(Diary diary) {
        return diaryRepository.save(diary).getId();
    }

    public Page<Diary> getAll(Integer page, Integer pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "date", "id");
        return diaryRepository.findAll(PageRequest.of(page, pageSize, sort));
    }

    public void update(Long diaryId, Diary diary) {
        Diary oldDiary = diaryRepository.findById(diaryId).orElseThrow(DiaryNotFoundException::new);
        oldDiary.updateDiary(diary.getDate(), diary.getContent());
        diaryRepository.save(oldDiary);
    }


    public void remove(Long diaryId) {
        Diary diary = diaryRepository.findById(diaryId).orElseThrow(DiaryNotFoundException::new);
        diaryRepository.delete(diary);
    }
}
