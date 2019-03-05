package com.xyd.webtask.service;

import com.xyd.webtask.entity.Goods;
import com.xyd.webtask.exception.NotFoundException;
import com.xyd.webtask.exception.Result;
import com.xyd.webtask.repository.GoodsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.xyd.webtask.util.Util.getNullPropertyNames;

@Service
public class GoodsService
{
    @Autowired
    private GoodsRepository goodsRepository;

    public Object addGoods(Goods goods)
    {
        return goodsRepository.save(goods);
    }

    public List<Goods> getGoodsList()
    {
        return goodsRepository.findAll();
    }

    public Object getGoods(Long id) throws NotFoundException
    {
        Goods currentInstance = goodsRepository.findById(id).get();
        if (currentInstance == null)
        {
            throw new NotFoundException("goods " + id + " is not exist!", Result.ErrorCode.GOODS_NOT_FOUND.getCode());
        }
        return goodsRepository.findById(id).get();
    }

    public void deleteGoods(Long id)
    {
        goodsRepository.deleteById(id);
    }

    public Goods update(Long id, Goods goods)
    {
        Goods currentInstance = goodsRepository.findById(id).get();

        String[] nullPropertyNames = getNullPropertyNames(goods);
        BeanUtils.copyProperties(goods, currentInstance, nullPropertyNames);

        return goodsRepository.save(currentInstance);
    }
}