/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.util.Date;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author a
 */
@ManagedBean(name = "DateBean")
public class DateBean
{
    public Date getDate()
    {
        return Calendar.getInstance().getTime();
    }
}
