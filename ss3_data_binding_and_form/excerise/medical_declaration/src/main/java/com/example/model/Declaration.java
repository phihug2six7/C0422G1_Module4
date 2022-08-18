package com.example.model;

public class Declaration {
    private int id;
    private String name;
    private String year;
    private String gender;
    private String nation;
    private String idCart;
    private String travelInformation;
    private String vehicleNumber;
    private int seats;
    private String dayStart;
    private String monthStart;
    private String yearsStart;
    private String dayEnd;
    private String monthEnd;
    private String yearsEnd;
    private String goCity;

    public Declaration() {
    }

    public Declaration(int id, String name, String year, String gender, String nation, String idCart,
                       String travelInformation, String vehicleNumber, int seats, String dayStart,
                       String monthStart, String yearsStart, String dayEnd, String monthEnd, String yearsEnd,
                       String goCity) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.nation = nation;
        this.idCart = idCart;
        this.travelInformation = travelInformation;
        this.vehicleNumber = vehicleNumber;
        this.seats = seats;
        this.dayStart = dayStart;
        this.monthStart = monthStart;
        this.yearsStart = yearsStart;
        this.dayEnd = dayEnd;
        this.monthEnd = monthEnd;
        this.yearsEnd = yearsEnd;
        this.goCity = goCity;
    }

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getMonthStart() {
        return monthStart;
    }

    public void setMonthStart(String monthStart) {
        this.monthStart = monthStart;
    }

    public String getYearsStart() {
        return yearsStart;
    }

    public void setYearsStart(String yearsStart) {
        this.yearsStart = yearsStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getMonthEnd() {
        return monthEnd;
    }

    public void setMonthEnd(String monthEnd) {
        this.monthEnd = monthEnd;
    }

    public String getYearsEnd() {
        return yearsEnd;
    }

    public void setYearsEnd(String yearsEnd) {
        this.yearsEnd = yearsEnd;
    }

    public String getGoCity() {
        return goCity;
    }

    public void setGoCity(String goCity) {
        this.goCity = goCity;
    }
}
