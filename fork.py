#!/usr/bin/python
# -*- coding: UTF-8 -*-
# fork maven-helloworld into a new project for development
# Author: jiangmingzhou

import os, sys, getopt, shutil

def show_usage():
    print("Usage:")
    print("\tfork.py -p|--project <project> -d|--directory <directory>")

def current_dir():
    # 设置路径
    path = "\\"
    # 获取指定路径下的文件
    dir = os.path.split(os.path.realpath(__file__))[0]
    return dir

def fork(project, directory):
    assert project != None and directory != None
    source_dir = current_dir()
    dest_dir = os.path.join(directory, project)

    if os.path.isdir(dest_dir):
        print("Already exist project %s in path %s" % (project, dest_dir))
        sys.exit(2)

    shutil.copytree(source_dir, dest_dir)
    '''
        rm intelj relatives
    '''
    os.remove(os.path.join(dest_dir, "maven-helloworld.iml"))
    shutil.rmtree(os.path.join(dest_dir, ".idea"))
    shutil.rmtree(os.path.join(dest_dir, "logs"))
    '''
        rm git relatives
    '''
    os.remove(os.path.join(dest_dir, ".gitignore"))
    shutil.rmtree(os.path.join(dest_dir, ".git"))

    s_pom = os.path.join(dest_dir, "pom.xml")
    d_pom = os.path.join(dest_dir, "pom-new.xml")
    with open(s_pom, 'r+') as fds:
        s_lines = fds.readlines()
        with open(d_pom, 'w+') as fdd:
            for s_line in s_lines:
                # replace 'artifactId' of maven project
                if "<artifactId>maven-helloworld</artifactId>" in s_line:
                    d_line = s_line.replace("maven-helloworld", project)
                    fdd.write(d_line)
                # replace executable jar file name
                elif "<finalName>helloworld</finalName>" in s_line:
                    d_line = s_line.replace("helloworld", project)
                    fdd.write(d_line)
                else:
                    fdd.write(s_line)
    os.remove(s_pom)
    os.rename(d_pom, s_pom)

    s_log4j = os.path.join(dest_dir, "src", "main", "resources", "log4j.properties")
    d_log4j = os.path.join(dest_dir, "src", "main", "resources", "log4j-new.properties")
    with open(s_log4j, 'r+') as fds:
        s_lines = fds.readlines()
        with open(d_log4j, 'w+') as fdd:
            for s_line in s_lines:
                # replace log file name
                if "log4j.appender.FILE.File=logs/helloworld.log" in s_line:
                    d_line = s_line.replace("helloworld", project)
                    fdd.write(d_line)
                else:
                    fdd.write(s_line)
    os.remove(s_log4j)
    os.rename(d_log4j, s_log4j)

def main(argv):
    project = None
    directory = None

    try:
        opts, args = getopt.getopt(argv, "hp:d:", ["project=", "directory="])
    except getopt.GetoptError:
        show_usage()
        sys.exit(2)

    for opt, arg in opts:
        if opt == "-h":
            show_usage()
            sys.exit()
        elif opt in ("-p", "--project"):
            project = arg
        elif opt in ("-d", "--directory"):
            if os.path.isdir(arg):
                directory = arg

    if project == None or directory == None:
        print("Invalid argument! project: %s, directory: %s\n" % (project, directory))
        show_usage()
        sys.exit(2)

    print("forking maven-helloworld into new project %s of which directory is %s" %
            (project, directory))
    fork(project, directory)
    print("done forking!")

if __name__ == "__main__":
   main(sys.argv[1:])
