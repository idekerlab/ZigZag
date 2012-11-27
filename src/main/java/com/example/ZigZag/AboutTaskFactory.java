package com.example.ZigZag;

import org.cytoscape.work.Task;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskMonitor;

import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

class AboutTaskFactory implements TaskFactory
{
    public TaskIterator createTaskIterator()
    {
        return new TaskIterator(new AboutTask());
    }

    public boolean isReady()
    {
        return true;
    }
}

class AboutTask implements Task
{
    public void run(TaskMonitor monitor)
    {
        /*
         * We have to wrap this in an "invokeLater"
         * so that the task dialog doesn't show up in the background
         * of our dialog.
         */
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JOptionPane.showMessageDialog(null, "<html><h1>Zig Zag <small>1.0</small></h1>An incredibly awesome app for finding paths of a node.</html>", "About Zig Zag", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public void cancel() {}
}
