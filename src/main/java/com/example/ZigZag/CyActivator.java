package com.example.ZigZag;

import org.cytoscape.work.Task;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskMonitor;

import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;
import static org.cytoscape.work.ServiceProperties.*;

/**
 * {@code CyActivator} is a class that is a starting point for
 * OSGi bundles. When OSGi first loads your bundle, it will
 * invoke {@CyActivator}'s {@code start} method. So, the
 * {@code start} method is where you put in all your code
 * that sets up your app.
 *
 * Your bundle's {@code Bundle-Activator} manifest entry
 * has a fully-qualified path to this class.
 * You don't really have to write a class that
 * extends {@code AbstractCyActivator}. However, we provide
 * this class as a convenience to make it easier to import
 * and export OSGi services.
 */
public class CyActivator extends AbstractCyActivator
{
    public void start(BundleContext bc)
    {
        final Properties props = new Properties();
        props.put(TITLE, "About Zig Zag");
        props.put(PREFERRED_MENU, "Apps");
        registerService(bc, new AboutTaskFactory(), TaskFactory.class, props);
    }
}
