package com.usa.reto3d.entities.counts;

import com.usa.reto3d.entities.Costume;

public class CountCostume {

    private Long total;
    private Costume skate;

    public CountCostume(Long total, Costume costume) {
        this.total = total;
        this.skate = costume;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Costume getCar() {
        return skate;
    }

    public void setCar(Costume room) {
        this.skate = room;
    }
}
