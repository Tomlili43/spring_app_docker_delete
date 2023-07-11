package com.aift.lukie.Service.innerService.Visualization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aift.lukie.Repository.Visualization.*;
import com.aift.lukie.Model.Visualization.*;
import java.util.*;

@Service
public class VisualizationService {
    @Autowired
    private CategoryCountsRepository categoryCountsRepository;
    @Autowired
    private CategoryTimeCoverageRepository categoryTimeCoverageRepository;
    @Autowired
    private ModifiedCountRepository modifiedCountRepository;
    @Autowired
    private UniqueProductsByMonthDmRepository uniqueProductsByMonthDmRepository;
    @Autowired
    private UniqueProductsByMonthJsRepository uniqueProductsByMonthJsRepository;
    @Autowired
    private UniqueProductsByMonthRepository uniqueProductsByMonthRepository;
    @Autowired
    private UsTransactionCountCnRepository usTransactionCountCnRepository;
    @Autowired
    private UsTransactionCountRepository usTransactionCountRepository;
    @Autowired
    private UsTransactionValueCnRepository usTransactionValueCnRepository;
    @Autowired
    private UsTransactionValueRepository usTransactionValueRepository;
    @Autowired
    private UsTransactionVolumeCnRepository usTransactionVolumeCnRepository;
    @Autowired
    private UsTransactionVolumeRepository usTransactionVolumeRepository;
    @Autowired
    private UsTransactionWeightCnRepository usTransactionWeightCnRepository;
    @Autowired
    private UsTransactionWeightRepository usTransactionWeightRepository;
    @Autowired
    private ModifiedCountAggProductAverageandsumRepository modifiedCountAggProductAverageandsumRepository;
    @Autowired
    private ModifiedCountAggProductAverageandsumPbRepository modifiedCountAggProductAverageandsumPbRepository;
    @Autowired
    private ModifiedCountAggSellerAverageandsumRepository modifiedCountAggSellerAverageandsumRepository;
    @Autowired
    private ModifiedCountAggSellerAverageandsumPbRepository modifiedCountAggSellerAverageandsumPbRepository;
    @Autowired
    private ModifiedCountDataMonthPbRepository modifiedCountDataMonthPbRepository;
    @Autowired
    private ModifiedCountDataMonthRepository modifiedCountDataMonthRepository;
    @Autowired
    private ModifiedCountDataProductPbRepository modifiedCountDataProductPbRepository;
    @Autowired
    private ModifiedCountDataProductRepository modifiedCountDataProductRepository;
    @Autowired
    private ModifiedCountSellerPbRepository modifiedCountSellerPbRepository;
    @Autowired
    private ModifiedCountSellerProductsPbRepository modifiedCountSellerProductsPbRepository;
    @Autowired
    private ModifiedCountSellerProductsRepository modifiedCountSellerProductsRepository;
    @Autowired
    private ModifiedCountSellerRepository modifiedCountSellerRepository;
    @Autowired
    private ModifiedTimesRepository modifiedTimesRepository;
    @Autowired
    private ModifiedTimesPbRepository modifiedTimesPbRepository;
    @Autowired
    private UniqueProductsByMonthDmPbRepository uniqueProductsByMonthDmPbRepository;


    public List<CategoryCounts> categoryCounts(){
        return categoryCountsRepository.findAll();
    }
    public List<CategoryTimeCoverage> categoryTimeCoverage(){
        return categoryTimeCoverageRepository.findAll();
    }
    public List<ModifiedCount> modifiedCount(){
        return modifiedCountRepository.findAll();
    }
    public List<UniqueProductsByMonthDm> uniqueProductsByMonthDm(){
        return uniqueProductsByMonthDmRepository.findAll();
    }
    public List<UniqueProductsByMonthJs> uniqueProductsByMonthJs(){
        return uniqueProductsByMonthJsRepository.findAll();
    }
    public List<UniqueProductsByMonth> uniqueProductsByMonth(){
        return uniqueProductsByMonthRepository.findAll();
    }
    public List<UsTransactionCountCn> usTransactionCountCn(){
        return usTransactionCountCnRepository.findAll();
    }
    public List<UsTransactionCount> usTransactionCount(){
        return usTransactionCountRepository.findAll();
    }
    public List<UsTransactionValueCn> usTransactionValueCn(){
        return usTransactionValueCnRepository.findAll();
    }
    public List<UsTransactionValue> usTransactionValue(){
        return usTransactionValueRepository.findAll();
    }
    public List<UsTransactionVolumeCn> usTransactionVolumeCn(){
        return usTransactionVolumeCnRepository.findAll();
    }
    public List<UsTransactionVolume> usTransactionVolume(){
        return usTransactionVolumeRepository.findAll();
    }
    public List<UsTransactionWeightCn> usTransactionWeightCn(){
        return usTransactionWeightCnRepository.findAll();
    }
    public List<UsTransactionWeight> usTransactionWeight(){
        return usTransactionWeightRepository.findAll();
    }
    public List<ModifiedCountAggProductAverageandsum> getModifiedCountAggProductAverageAndSum() {
        return modifiedCountAggProductAverageandsumRepository.findAll();
    }
    
    public List<ModifiedCountAggProductAverageandsumPb> getModifiedCountAggProductAverageAndSumPb() {
        return modifiedCountAggProductAverageandsumPbRepository.findAll();
    }
    
    public List<ModifiedCountAggSellerAverageandsum> getModifiedCountAggSellerAverageAndSum() {
        return modifiedCountAggSellerAverageandsumRepository.findAll();
    }
    
    public List<ModifiedCountAggSellerAverageandsumPb> getModifiedCountAggSellerAverageAndSumPb() {
        return modifiedCountAggSellerAverageandsumPbRepository.findAll();
    }
    public List<ModifiedCountDataMonth> getModifiedCountDataMonth() {
        return modifiedCountDataMonthRepository.findAll();
    }
    public List<ModifiedCountDataMonthPb> getModifiedCountDataMonthPb() {
        return modifiedCountDataMonthPbRepository.findAll();
    }
    public List<ModifiedCountDataProduct> getModifiedCountDataProduct() {
        return modifiedCountDataProductRepository.findAll();
    }
    public List<ModifiedCountDataProductPb> getModifiedCountDataProductPb() {
        return modifiedCountDataProductPbRepository.findAll();
    }
    public List<ModifiedCountSeller> getModifiedCountSeller() {
        return modifiedCountSellerRepository.findAll();
    }
    public List<ModifiedCountSellerPb> getModifiedCountSellerPb() {
        return modifiedCountSellerPbRepository.findAll();
    }
    public List<ModifiedCountSellerProducts> getModifiedCountSellerProducts() {
        return modifiedCountSellerProductsRepository.findAll();
    }
    public List<ModifiedCountSellerProductsPb> getModifiedCountSellerProductsPb() {
        return modifiedCountSellerProductsPbRepository.findAll();
    }
    public List<ModifiedTimes> getModifiedTimes() {
        return modifiedTimesRepository.findAll();
    }
    public List<ModifiedTimesPb> getModifiedTimesPb() {
        return modifiedTimesPbRepository.findAll();
    }
    public List<UniqueProductsByMonthDmPb> getUniqueProductsByMonthDmPb() {
        return uniqueProductsByMonthDmPbRepository.findAll();
    }
}
