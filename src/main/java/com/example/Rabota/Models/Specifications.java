package com.example.Rabota.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Specifications {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String CPU;
    private int RAM;
    private String MemorySize;
    private String GPU;
    private String OS;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}


    public String getCPU() {return CPU;}

    public void setCPU(String CPU) {this.CPU = CPU;}


    public int getRAM() {return RAM;}

    public void setRAM(int RAM) {this.RAM = RAM;}


    public String getMemorySize() {return MemorySize;}

    public void setMemorySize(String MemorySize) {this.MemorySize = MemorySize;}


    public String getGPU() {return GPU;}

    public void setGPU(String GPU) {this.GPU = GPU;}


    public String getOS() {return OS;}

    public void setOS(String OS) {this.OS = OS;}


    public Specifications() {}

    public Specifications(String CPU, int RAM, String MemorySize, String GPU, String OS) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.MemorySize = MemorySize;
        this.GPU = GPU;
        this.OS = OS;
    }

}
