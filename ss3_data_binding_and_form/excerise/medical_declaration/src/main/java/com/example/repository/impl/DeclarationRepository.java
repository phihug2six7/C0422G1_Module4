package com.example.repository.impl;

import com.example.model.Declaration;
import com.example.repository.IDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeclarationRepository implements IDeclarationRepository {
    private static List<String> listYears = new ArrayList<>();
    private static List<String> listGender = new ArrayList<>();
    private static List<String> listNation = new ArrayList<>();
    private static List<String> listTravelInformation = new ArrayList<>();
    private static List<String> listDayStart = new ArrayList<>();
    private static List<String> listMonthStart = new ArrayList<>();
    private static List<String> listYearsStart = new ArrayList<>();
    private static List<String> listDayEnd = new ArrayList<>();
    private static List<String> listMonthEnd = new ArrayList<>();
    private static List<String> listYearsEnd = new ArrayList<>();
    private static List<Declaration> declarationList = new ArrayList<>();

    static {
        for (int i = 1990; i < 2022; i++) {
            listYears.add(i + "");
        }

        listGender.add("Nam");
        listGender.add("Nữ");
        listGender.add("Giới tính khác");

        listNation.add("Việt Nam");
        listNation.add("Trung Quốc");
        listNation.add("Hàn Quốc");
        listNation.add("Nhật Bản");

        listTravelInformation.add("Tàu bay");
        listTravelInformation.add("Tàu thuyền");
        listTravelInformation.add("Ô tô");
        listTravelInformation.add("Khác (ghi rõ)");

        for (int i = 1; i < 31; i++) {
            listDayStart.add(i + "");
        }

        for (int i = 1; i < 12; i++) {
            listMonthStart.add(i + "");
        }

        for (int i = 1990; i < 2022; i++) {
            listYearsStart.add(i + "");
        }

        for (int i = 1; i < 31; i++) {
            listDayEnd.add(i + "");
        }

        for (int i = 1; i < 12; i++) {
            listMonthEnd.add(i + "");
        }

        for (int i = 1990; i < 2022; i++) {
            listYearsEnd.add(i + "");
        }

        declarationList.add(new Declaration(1, "hung", "2001", "nam", "Việt Nam",
                "1234", "Tàu Thuyền",
                "VN-123", 2, "12", "1", "2019", "13",
                "1", "2019", "Sài Gòn"));
        declarationList.add(new Declaration(2, "hung", "2001", "nam", "Việt Nam",
                "1234", "Tàu Thuyền",
                "VN-123", 2, "12", "1", "2019", "13",
                "1", "2019", "Sài Gòn"));
        declarationList.add(new Declaration(3, "hung", "2001", "nam", "Việt Nam",
                "1234", "Tàu Thuyền",
                "VN-123", 2, "12", "1", "2019", "13",
                "1", "2019", "Sài Gòn"));

    }


    @Override
    public List<String> findAllYears() {
        return listYears;
    }

    @Override
    public List<String> findAllGender() {
        return listGender;
    }

    @Override
    public List<String> findALlNation() {
        return listNation;
    }

    @Override
    public List<String> findAllTravelInformation() {
        return listTravelInformation;
    }

    @Override
    public List<String> findAllDayStart() {
        return listDayStart;
    }

    @Override
    public List<String> findAllMonthStart() {
        return listMonthStart;
    }

    @Override
    public List<String> findAllYearsStart() {
        return listYearsStart;
    }

    @Override
    public List<String> findAllDayEnd() {
        return listDayEnd;
    }

    @Override
    public List<String> findAllMonthEnd() {
        return listMonthEnd;
    }

    @Override
    public List<String> findAllYearsEnd() {
        return listYearsEnd;
    }

    @Override
    public List<Declaration> findAll() {
        return declarationList;
    }

    @Override
    public Declaration findById(int id) {
        for (Declaration declaration : declarationList) {
            if (declaration.getId() == id) {
                return declaration;
            }
        }
        return null;
    }

    @Override
    public void create(Declaration declaration) {
        declarationList.add(declaration);
    }

    @Override
    public void update(int id, Declaration declaration) {
        for (Declaration dec : declarationList) {
            if (dec.getId() == id) {
                dec.setName(declaration.getName());
                dec.setYear(declaration.getYear());
                dec.setGender(declaration.getGender());
                dec.setNation(declaration.getNation());
                dec.setIdCart(declaration.getIdCart());
                dec.setTravelInformation(declaration.getTravelInformation());
                dec.setVehicleNumber(declaration.getVehicleNumber());
                dec.setSeats(declaration.getSeats());
                dec.setDayStart(declaration.getDayStart());
                dec.setMonthStart(declaration.getMonthStart());
                dec.setYearsStart(declaration.getYearsStart());
                dec.setDayEnd(declaration.getDayEnd());
                dec.setMonthEnd(declaration.getMonthEnd());
                dec.setYearsEnd(declaration.getYearsEnd());
                dec.setGoCity(declaration.getGoCity());
            }
        }
    }
}
