package org.insa.base;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.insa.graph.Graph;
import org.insa.graph.Path;
import org.insa.graph.io.BinaryGraphReader;
import org.insa.graph.io.BinaryPathReader;
import org.insa.graph.io.GraphReader;
import org.insa.graphics.drawing.Drawing;
import org.insa.graphics.drawing.components.BasicDrawing;

public class Launch {

    /**
     * Create a new Drawing inside a JFrame an return it.
     * 
     * @return The created drawing.
     * 
     * @throws Exception if something wrong happens when creating the graph.
     */
    public static Drawing createDrawing() throws Exception {
        BasicDrawing basicDrawing = new BasicDrawing();
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("BE Graphes - Launch");
                frame.setLayout(new BorderLayout());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setSize(new Dimension(800, 600));
                frame.setContentPane(basicDrawing);
                frame.validate();
            }
        });
        return basicDrawing;
    }

    public static void main(String[] args) throws Exception {

        // Visit these directory to see the list of available files on Commetud.
        String mapName = "maps/haute-garonne/haute-garonne.mapgr";
        String pathName = "paths/path_fr31_insa_aeroport_time.path";

        // Create a graph reader.
        GraphReader reader = new BinaryGraphReader(
                new DataInputStream(new BufferedInputStream(new FileInputStream(mapName))));

        // TODO: Read the graph.
        Graph graph = reader.read();

        // Create the drawing:
        Drawing drawing = createDrawing();

        // TODO: Draw the graph on the drawing.
        drawing.drawGraph(graph);
        
        // TODO: Create a PathReader.
        BinaryPathReader pathReader = new BinaryPathReader(new DataInputStream(
        		new BufferedInputStream(new FileInputStream(pathName))));

        // TODO: Read the path.
        Path path = pathReader.readPath(graph);

        // TODO: Draw the path.
        drawing.drawPath(path);

    }

}
