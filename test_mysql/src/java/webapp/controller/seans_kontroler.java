/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.controller;

import kino.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author PAWEL
 */
@ManagedBean(name = "seans_kontroler")
@SessionScoped
public class seans_kontroler {

    kinoHQL kino_HQL;
    int startId;
    int endId;
    int selected_seans;
    private Seans current_seans;

    DataModel seanse;

    private int selectedItemIndex2;

    /**
     * TODO
     */
    public seans_kontroler() {
        kino_HQL = new kinoHQL();
    }

    /**
     *
     * @param startId
     * @param endId
     */
    public seans_kontroler(int startId, int endId) {
        kino_HQL = new kinoHQL();
        this.startId = startId;
        this.endId = endId;
    }

    /**
     *
     * @param selected_seans
     */
    public seans_kontroler(int selected_seans) {
        kino_HQL = new kinoHQL();
        this.selected_seans = selected_seans;
    }

    /**
     *
     * @return
     */
    public Seans getSelected() {
        if (current_seans == null) {
            current_seans = new Seans();
            selectedItemIndex2 = -1;
        }
        return current_seans;
    }

    /**
     *
     * @return
     */
    public DataModel getSeanse() {
        if (seanse == null) {
            seanse = new ListDataModel(kino_HQL.getSeanse());
        }
        return seanse;
    }

    /**
     * TODO
     */
    void recreateModel() {
        seanse = null;
    }

    /**
     *
     * @return
     */
    public String prepareView() {
        return "seanse";
    }
}
