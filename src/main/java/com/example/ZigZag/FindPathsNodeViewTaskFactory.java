package com.example.ZigZag;

import org.cytoscape.work.Task;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.task.NodeViewTaskFactory;
import org.cytoscape.view.model.View;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyle;

import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FindPathsNodeViewTaskFactory implements NodeViewTaskFactory
{
    final VisualMappingManager vizManager;

    public FindPathsNodeViewTaskFactory(final VisualMappingManager vizManager)
    {
        this.vizManager = vizManager;
    }

    public TaskIterator createTaskIterator( View<CyNode> nodeView, CyNetworkView networkView)
    {
        return new TaskIterator(new FindPathsNodeViewTask(vizManager, nodeView, networkView));
    }

    public boolean isReady(View<CyNode> nodeView, CyNetworkView networkView)
    {
        return true;
    }
}

class FindPathsNodeViewTask implements Task
{
    final static Logger logger = LoggerFactory.getLogger(FindPathsNodeViewTask.class);

    final VisualMappingManager vizManager;
    final View<CyNode> nodeView;
    final CyNetworkView networkView;

    public FindPathsNodeViewTask(VisualMappingManager vizManager, View<CyNode> nodeView, CyNetworkView networkView)
    {
        this.vizManager = vizManager;
        this.nodeView = nodeView;
        this.networkView = networkView;
    }

    public void run(TaskMonitor monitor)
    {
        final Set<CyNode> nodes = new HashSet<CyNode>();
        final Set<CyEdge> edges = new HashSet<CyEdge>();
        final Stack<CyNode> pending = new Stack<CyNode>();

        final CyNetwork network = networkView.getModel();
        final CyNode startingNode = nodeView.getModel();
        pending.push(startingNode);

        while (!pending.isEmpty())
        {
            final CyNode node = pending.pop();
            if (nodes.contains(node))
                continue;
            pending.addAll(network.getNeighborList(node, CyEdge.Type.OUTGOING));
            edges.addAll(network.getAdjacentEdgeList(node, CyEdge.Type.OUTGOING));
            nodes.add(node);
        }

        resetVisualStyle(networkView);
        setVisualStyleForPaths(networkView, nodes, edges);
        applyVisualStyle(vizManager, networkView);
    }

    public void cancel() {}

    private static void resetVisualStyle(final CyNetworkView networkView)
    {
        final CyNetwork network = networkView.getModel();

        for (final CyNode node : network.getNodeList())
            networkView.getNodeView(node).clearValueLock(BasicVisualLexicon.NODE_BORDER_WIDTH);		

        for (final CyEdge edge : network.getEdgeList())
            networkView.getEdgeView(edge).clearValueLock(BasicVisualLexicon.EDGE_PAINT);		
    }

    private static void setVisualStyleForPaths(final CyNetworkView networkView, final Set<CyNode> nodes, final Set<CyEdge> edges)
    {
        for (final CyNode node : nodes)
            networkView.getNodeView(node).setLockedValue(BasicVisualLexicon.NODE_BORDER_WIDTH, 9.0);

        for (final CyEdge edge : edges)
            networkView.getEdgeView(edge).setLockedValue(BasicVisualLexicon.EDGE_PAINT, java.awt.Color.RED);
    }

    private static void applyVisualStyle(final VisualMappingManager vizManager, final CyNetworkView networkView)
    {
		final VisualStyle style = vizManager.getCurrentVisualStyle();
		style.apply(networkView);
		networkView.updateView();
    }
}
