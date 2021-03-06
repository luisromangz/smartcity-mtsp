/*
 * Copyright (C) 2014 Emergya
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.emergya.mtsp.webapp.controller;

import com.emergya.mtsp.ga.MTSPGeneticsHandler;
import com.emergya.mtsp.ga.MTSPRoutes;
import com.emergya.mtsp.model.Vehicle;
import com.emergya.mtsp.webapp.dto.MTSPRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lroman
 */
@RestController
@RequestMapping("/v1")
public class WSController {
    
    @Autowired
    MTSPGeneticsHandler mtspHandler;
    
    @ResponseBody    
    @RequestMapping(method = RequestMethod.GET)    
    public String test() {

        return "Try using POST on /calculte path";
    }
    
    @ResponseBody
    @RequestMapping(value = "calculateMTSP", method = RequestMethod.POST)
    public MTSPRoutes calculateMTSP(@RequestBody MTSPRequest request) {
        List<Vehicle> vehicles =new ArrayList<>();
        vehicles.add(new Vehicle("Vehicle 1", 1));
        vehicles.add(new Vehicle("Vehicle 2", 1));
        return mtspHandler.calculateMTSP(request.getOrigin(), request.getStops(), vehicles);
    }
    
}
