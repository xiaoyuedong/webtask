package com.xyd.webtask.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xyd.webtask.entity.Goods;
import com.xyd.webtask.exception.NotFoundException;
import com.xyd.webtask.service.GoodsService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
    private GoodsService goodsService;
	
    @ApiOperation(value="商品リスト", notes="商品リスト")
    @GetMapping(value = "/")
    public List<Goods> getGoodsList(){
        return goodsService.getGoodsList();
    }
	
	@ApiOperation(value="商品登録", notes="商品登録")
	@ApiImplicitParam(name = "goods", value = "商品データgoods", required = true, dataType = "Goods", paramType = "body")
	@PostMapping(value="/")
	@ResponseStatus(HttpStatus.CREATED)
	public Object postGoods(@Valid @RequestBody Goods goods) {
		return goodsService.addGoods(goods);
	}
	@ApiOperation(value="商品検索", notes="URLのIDによって商品データをリターン")
	@ApiImplicitParam(name = "id", value = "商品ID", required = true, dataType = "long", paramType = "path")
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
    public Object getGoods(@PathVariable long id)throws NotFoundException{
		return goodsService.getGoods(id);
    }
	@ApiOperation(value="商品変更", notes="URLのIDによって商品を指定，JSONによって変更")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "id", value = "商品ID", required = true, dataType = "long", paramType = "path"),
	@ApiImplicitParam(name = "goods", value = "商品データgoods", required = true, dataType = "Goods", paramType = "body")
	})
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Goods putGoods(@PathVariable long id,@Valid @RequestBody Goods goods) {
		return goodsService.update(id, goods);
	}
	@ApiOperation(value="商品削除", notes="URLのIDによって削除")
	@ApiImplicitParam(name = "id", value = "商品ID", required = true, dataType = "long", paramType = "path")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteGoods(@PathVariable long id) {
		goodsService.deleteGoods(id);
	}
}