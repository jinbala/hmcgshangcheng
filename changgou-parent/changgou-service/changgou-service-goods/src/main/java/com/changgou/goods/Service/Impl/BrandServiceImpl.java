package com.changgou.goods.Service.Impl;

import changgou.goods.pojo.Brand;
import com.changgou.goods.Service.BrandService;
import com.changgou.goods.mapper.BrandMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;
    /**
     * 查询所有品牌
     */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    /**
     * 根据id查询所需要的品牌
     *
     * @param id
     */
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加你所需要的名称对象
     * @param brand
     * @return
     */
    @Override
    public boolean add(Brand brand) {
        int insert = brandMapper.insert(brand);
        boolean index = insert>= 0? true:false;
        return index;
    }

    /**
     * 修改品牌
     * @param brand
     */
    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询
     *
     * @param brand
     * @return
     */
    @Override
    public List<Brand> findList(Brand brand) {

        //根据构建的条件查询数据
        Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }

    /**
     * 条件 分页查询
     * @param brand
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Brand> findPage(Brand brand, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(brand);
        //执行搜索
        return new PageInfo<Brand>(brandMapper.selectByExample(example));
    }

    private Example createExample(Brand brand) {
        //构建查询条件
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (brand!=null){
        //id
        if (!StringUtils.isEmpty(brand.getId())) {
            criteria.andEqualTo("id", brand.getId());
        }
        //执行查询
        if (!StringUtils.isEmpty(brand.getName())) {
            criteria.andLike("name", "%" + brand.getName() + "%");
        }
        //首字母
        if (!StringUtils.isEmpty(brand.getLetter())) {
            criteria.andEqualTo("letter", brand.getLetter());
        }
        //图片地址
        if (!StringUtils.isEmpty(brand.getImage())) {
            criteria.andLike("image", "%" + brand.getLetter() + "%");
        }
        //排序
        if (!StringUtils.isEmpty(brand.getSeq())) {
            criteria.andEqualTo("seq", brand.getSeq());
        }
    }
        return example;
    }
}
