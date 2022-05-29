package com.changgou.goods.controller;

import changgou.goods.pojo.Brand;
import com.changgou.goods.Service.BrandService;
import com.changgou.util.Result;
import com.changgou.util.StatusCode;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {
    @Autowired
    private BrandService brandService;
    /**
     * 查询全部数据
     */
    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> list = brandService.findAll();
        return new Result<>(true, StatusCode.OK,"查询成功",list);
    }

    /**
     * 根据id查询所需要的品牌
     */
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id){
        Brand brand = brandService.findById(id);
        return new Result<>(true,StatusCode.OK,"查询成功",brand);
    }

    /**
     * 新增
     */
    @PostMapping
    public Result add (@RequestBody Brand brand){
        boolean index = brandService.add(brand);
        return new Result<>(true,StatusCode.OK,"新增成功");
    }

    /**
     * 修改
     */
    @PutMapping
    public Result update(@RequestBody(required = false) Brand brand){
        brandService.update(brand);
        return new Result<>(true,StatusCode.OK,"修改成功");
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result update(@PathVariable(value ="id") Integer id){
        brandService.delete(id);
        return new Result<>(true,StatusCode.OK,"删除成功");
    }

    /**
     * 条件查询
     * @param brand
     * @return
     */
    @PostMapping(value = "/search")
    public Result<List<Brand>> search(@RequestBody(required = false) Brand brand){
        List<Brand> list = brandService.findList(brand);
        return new Result<List<Brand>>(true,StatusCode.OK,"查询成功",list);
    }

    /**
     * 分页搜索实现
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findpage(@RequestBody(required = false) Brand brand,@PathVariable int page,@PathVariable int size){
        //执行搜索
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }


}
