# Get Started with Eclipse

Set up Eclipse for Cytoscape 3.0 app development with this guide.
The version of Eclipse we will be using is Juno Service Release 1.

# Download and Install Eclipse

 1. Download _Eclipse IDE for Java Developers_ from <http://www.eclipse.org/downloads/>.

    ![](https://raw.github.com/cytoscape/ZigZag/master/getstartedwitheclipse/download1.png)

    ![](https://raw.github.com/cytoscape/ZigZag/master/getstartedwitheclipse/download2.png)

 1. Extract the downloaded archive.

    ![](https://raw.github.com/cytoscape/ZigZag/master/getstartedwitheclipse/extract.png)

    You should now have a folder with Eclipse:

    ![](https://raw.github.com/cytoscape/ZigZag/master/getstartedwitheclipse/extract2.png)

# Start Eclipse

 1. Start the Eclipse application.

    ![](https://raw.github.com/cytoscape/ZigZag/master/getstartedwitheclipse/launch.png)

 1. If you get this dialog, just click _OK_.

    ![](https://raw.github.com/cytoscape/ZigZag/master/getstartedwitheclipse/workspacesetup.png)

 1. If you see this window, click the _Workbench_ icon.

    ![](https://raw.github.com/cytoscape/ZigZag/master/getstartedwitheclipse/welcomescreen.png)

    Now you should be seeing Eclipse's _Workbench_ window.

    ![](https://raw.github.com/cytoscape/ZigZag/master/getstartedwitheclipse/workspace.png)

# Create the project

 1. In the menu bar, choose _File_ &rarr; _Import_.

 1. Open the _Maven_ folder, then click on _Existing Maven Projects_. Click _Next_.

   ![](https://raw.github.com/cytoscape/ZigZag/master/getstartedwitheclipse/newmvnproj.png)

 1. Click the _Browse_ button on the top-right, and select the _ZigZag_ directory. Now click _Finish_.

   ![](https://raw.github.com/cytoscape/ZigZag/master/getstartedwitheclipse/newmvnproj2.png)

# Building and running your app

 1. Right click on _pom.xml_, then choose _Run As_ &rarr; _Maven install_.

   ![](https://raw.github.com/cytoscape/ZigZag/master/getstartedwitheclipse/mvninstall.png)

 1. When your app has been built, open up Cytoscape. Once Cytoscape has finished starting up,
    copy your app's jar to the  _CytoscapeConfiguration/3/apps/installed_ folder.
    _CytoscapeConfiguration_ is located in your home folder.

 1. Now that your app jar has been copied, Cytoscape will pick up the jar and load it. You do
    not have to restart Cytoscape when you make changes to your app and put in a new jar.
