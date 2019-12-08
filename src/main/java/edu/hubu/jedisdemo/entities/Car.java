package edu.hubu.jedisdemo.entities;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName Car
 * @Description TODO
 * @createTime 2019年10月17日 22:33:00
 */

import java.io.Serializable;

/*
 * 汽车类
 */
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    /*
     * 编号
     */
    private int id;
    /*
     * 车名
     */
    private String name;
    /*
     * 车速
     */
    private double speed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Car(int id, String name, double speed) {
        this.id = id;
        this.name = name;
        this.speed = speed;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car [id=" + id + ", name=" + name + ", speed=" + speed + "]";
    }
}