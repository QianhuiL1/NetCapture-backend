package com.ruoyi.system.domain;

public class SpreadtreePersonInfo {
    private PersonInfo dadInfo;
    private Long relationship;
    private PersonInfo sonInfo;

    public Long getRelationship() {
        return relationship;
    }

    public void setRelationship(Long relationship) {
        this.relationship = relationship;
    }

    public PersonInfo getSonInfo() {
        return sonInfo;
    }

    public void setSonInfo(PersonInfo sonInfo) {
        this.sonInfo = sonInfo;
    }

    public PersonInfo getDadInfo() {
        return dadInfo;
    }

    public void setDadInfo(PersonInfo dadInfo) {
        this.dadInfo = dadInfo;
    }


}
