package edu.hubu.jedisdemo.dao;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName CarDAO
 * @Description TODO
 * @createTime 2019年10月17日 22:36:00
 */

import edu.hubu.jedisdemo.entities.Car;
import edu.hubu.jedisdemo.utils.SerializeUitl;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/*
 * 数据访问类
 */
public class CarDAO {

    //汽车集合
    private List<Car> cars;

    //初始化时加载所有的数据
    public CarDAO() {
        load();
    }

    /*
     * 将数据保存到redis数据库中
     */
    public void save() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("cars".getBytes(), SerializeUitl.serialize(cars));
        jedis.bgsave();
        jedis.close();
    }

    /*
     * 从redis数据库中加载数据
     */
    public void load() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        byte[] byties = jedis.get("cars".getBytes());
        if (byties != null && byties.length > 0) {
            cars = (List<Car>) SerializeUitl.deSerialize(byties, Car.class);
        } else {
            cars = new ArrayList<Car>();
        }
        jedis.close();
    }

    //添加
    public void add(Car car) {
        this.cars.add(car);
        save();
    }

    //获得对象通过编号
    public Car getCarById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    //移除
    public void remove(int id) {
        cars.remove(getCarById(id));
        save();
    }

    //获得所有
    public List<Car> getCars() {
        return cars;
    }

    //批量添加
    public void setCars(List<Car> cars) {
        this.cars = cars;
        save();
    }
}
