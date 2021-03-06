/*
 * Copyright (c) 2013 The Johns Hopkins University/Applied Physics Laboratory
 *                             All rights reserved.
 *
 * This material may be used, modified, or reproduced by or for the U.S.
 * Government pursuant to the rights granted under the clauses at
 * DFARS 252.227-7013/7014 or FAR 52.227-14.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * NO WARRANTY.   THIS MATERIAL IS PROVIDED "AS IS."  JHU/APL DISCLAIMS ALL
 * WARRANTIES IN THE MATERIAL, WHETHER EXPRESS OR IMPLIED, INCLUDING (BUT NOT
 * LIMITED TO) ANY AND ALL IMPLIED WARRANTIES OF PERFORMANCE,
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, AND NON-INFRINGEMENT OF
 * INTELLECTUAL PROPERTY RIGHTS. ANY USER OF THE MATERIAL ASSUMES THE ENTIRE
 * RISK AND LIABILITY FOR USING THE MATERIAL.  IN NO EVENT SHALL JHU/APL BE
 * LIABLE TO ANY USER OF THE MATERIAL FOR ANY ACTUAL, INDIRECT,
 * CONSEQUENTIAL, SPECIAL OR OTHER DAMAGES ARISING FROM THE USE OF, OR
 * INABILITY TO USE, THE MATERIAL, INCLUDING, BUT NOT LIMITED TO, ANY DAMAGES
 * FOR LOST PROFITS.
 */

package edu.jhuapl.graphs.jfreechart;

import edu.jhuapl.graphs.DataPoint;
import edu.jhuapl.graphs.DataSeries;
import edu.jhuapl.graphs.GraphException;
import edu.jhuapl.graphs.GraphSource;
import edu.jhuapl.graphs.PointInterface;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.*;

public class PieEffectsTest {

    /**
     * @param args
     */
    public static void main(String[] args) throws GraphException {
        JFreeChart chart = getSource().getChart();
        JFrame frame = new JFrame("Graph");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ChartPanel content = new ChartPanel(chart);
        content.setPreferredSize(new Dimension(800, 500));

        frame.getContentPane().add(content);

        frame.pack();
        frame.setVisible(true);
    }

    public static JFreeChartGraphSource getSource() throws GraphException {
        Map<String, Object> emptyMap = Collections.emptyMap();

        List<PointInterface> ps1 = new LinkedList<PointInterface>();

        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put(GraphSource.ITEM_COLOR, Color.red);
        ps1.add(new DataPoint(3, "Red", params));

        params = new HashMap<String, Object>(1);
        params.put(GraphSource.ITEM_COLOR, Color.green);
        ps1.add(new DataPoint(5, "Green", params));

        params = new HashMap<String, Object>(1);
        params.put(GraphSource.ITEM_COLOR, Color.blue);
        ps1.add(new DataPoint(7, "Blue", params));

        DataSeries s1 = new DataSeries(ps1, emptyMap);

        Map<String, Object> graphParams = new HashMap<String, Object>();
        graphParams.put(GraphSource.GRAPH_TYPE, GraphSource.GRAPH_TYPE_PIE);
        graphParams.put(GraphSource.GRAPH_LEGEND, true);

        JFreeChartGraphSource source = new JFreeChartGraphSource();
        source.setData(Arrays.asList(s1));
        source.setParams(graphParams);
        source.initialize();

        return source;
    }

}
