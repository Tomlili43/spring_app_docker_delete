package com.aift.lukie.utilities;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("reverse-config")
@Getter
@Setter
public class ReverseConfigProperties {

    private String database;
    private String tableName;
    private String url;
    private String user;
    private String password;

    private String inputEntityPath;
    private String inputRepositoryPath;
    private String fixPath;

    @Value("${reverse-config.fixPath}${reverse-config.inputEntityPath}")
    private String entityPath;
    @Value("${reverse-config.fixPath}${reverse-config.inputRepositoryPath}")
    private String repositoryPath;

    private String entityPackage; //this.inputEntityPath.replace('/', '.');
    private String repositoryPackage;//this.inputRepositoryPath.replace('/', '.');

    /// after confirmation of giving value to elements, using them to generate new elements.
    @PostConstruct
    public void init(){
        this.entityPackage = this.inputEntityPath.replace('/', '.');
        if (this.entityPackage.endsWith(".")) {
            this.entityPackage = this.entityPackage.substring(0, this.entityPackage.length() - 1);
        }
        this.repositoryPackage = this.inputRepositoryPath.replace('/', '.');
        if (this.repositoryPackage.endsWith(".")) {
            this.repositoryPackage = this.repositoryPackage.substring(0, this.repositoryPackage.length() - 1);
        }
    }

    @Override
    public String toString() {
        return "ReverseConfigProperties{" +
                "database=" + database +
                ", inputEntityPath='" + inputEntityPath + '\'' +
                ", inputRepositoryPath='" + inputRepositoryPath + '\'' +
                ", fixPath='" + fixPath + '\'' +
                ", entityPath='" + entityPath + '\'' +
                ", repositoryPath='" + repositoryPath + '\'' +
                ", entityPackage='" + entityPackage + '\'' +
                ", repositoryPackage='" + repositoryPackage + '\'' +
                '}';
    }
}