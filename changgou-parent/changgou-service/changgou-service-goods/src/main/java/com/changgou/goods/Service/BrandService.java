package com.changgou.goods.Service;

import changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有品牌
     */
    List<Brand> findAll();

    /**
     * 根据id查询所需要的品牌
     */
    Brand findById(Integer id);

    /**
     * 新增
     * @param brand
     * @return
     */
    boolean add(Brand brand);

    /**
     * 修改
     * @param brand
     */
    void update(Brand brand);

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 查询
     * @param brand
     * @return
     */
    List<Brand> findList(Brand brand);

    PageInfo<Brand> findPage(Brand brand,int page, int size);
}
