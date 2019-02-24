package com.xyd.webtask.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyd.webtask.entity.Goods;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	
	List<Goods> list = new ArrayList<Goods>();
	
	@ApiOperation(value="商品登録", notes="商品登録")
	@ApiImplicitParam(name = "goods", value = "商品データgoods", required = true, dataType = "Goods", paramType = "body")
	@PostMapping(value="/")
	public Goods postGoods(@RequestBody Goods goods) {
		Goods g = new Goods(
		goods.getId(),
		goods.getImg(),
		goods.getTitle(),
		goods.getDescription(),
		goods.getPrice());
		list.add(g);
		return g;
	}
	@ApiOperation(value="商品検索", notes="URLのIDによって商品データをリターン")
	@ApiImplicitParam(name = "id", value = "商品ID", required = true, dataType = "long", paramType = "path")
	@GetMapping("/{id}")
    public Goods getGoods(@PathVariable long id){
		int len=list.size();
		for(int i =0; i<len;i++) {
			if (list.get(i).getId()==id) {
				return list.get(i);
			}
		}
		return null;
    }
	@ApiOperation(value="商品変更", notes="URLのIDによって商品を指定，JSONによって変更")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "id", value = "商品ID", required = true, dataType = "long", paramType = "path"),
	@ApiImplicitParam(name = "goods", value = "商品データgoods", required = true, dataType = "Goods", paramType = "body")
	})
	@PutMapping("/{id}")
	public Goods putGoods(@PathVariable long id, @RequestBody Goods goods) {
		int len=list.size();
		for(int i =0; i<len;i++) {
			if (list.get(i).getId()==id) {
				list.get(i).setTitle(goods.getTitle());
				list.get(i).setDescription(goods.getDescription());
				list.get(i).setImg(goods.getImg());
				list.get(i).setPrice(goods.getPrice());
				return list.get(i);
			}
		}
		return null;
	}
	@ApiOperation(value="商品削除", notes="URLのIDによって削除")
	@ApiImplicitParam(name = "id", value = "商品ID", required = true, dataType = "long", paramType = "path")
	@DeleteMapping("/{id}")
	public String deleteGoods(@PathVariable long id) {
		int len=list.size();
		for(int i =0; i<len;i++) {
			if (list.get(i).getId()==id) {
				list.remove(i);
			}
		}
		return "delete done";
	}
}