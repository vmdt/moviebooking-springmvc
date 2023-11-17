package com.bookmovie.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookmovie.entity.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
//	@Query(value = "SELECT m FROM movie m WHERE m.type_id = ?", nativeQuery = true)
//	public List<MovieEntity> findByTypeId(Long typeId);
	
	public List<MovieEntity> findAllByTypeId(Long typeId, Pageable pageable);
	public List<MovieEntity> findAllByNationId(Long nationId, Pageable pageable);
	public List<MovieEntity> findAllByTypeIdAndNationId(Long typeId, Long nationId, Pageable pageable);
	public long countByTypeId(Long typeId);
	public long countByNationId(Long nationId);
	public long countByTypeIdAndNationId(Long typeId, Long nationId);
	
	public List<MovieEntity> findByMovieNameContains(String keyword);
}
