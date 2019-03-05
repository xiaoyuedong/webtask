package com.xyd.webtask.repository;

import com.xyd.webtask.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long>
{
}