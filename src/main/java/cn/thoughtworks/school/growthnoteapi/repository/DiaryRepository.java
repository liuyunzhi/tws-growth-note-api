package cn.thoughtworks.school.growthnoteapi.repository;

import cn.thoughtworks.school.growthnoteapi.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
