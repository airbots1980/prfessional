"""example file """
# /usr/bin/python

import os
with open('/tmp/list.txt','r') as f:
    for line in f:
        os.system('sshpass -p "pass" scp -r user@server:/dir' + line.rstrip() + ' /tmp/')
