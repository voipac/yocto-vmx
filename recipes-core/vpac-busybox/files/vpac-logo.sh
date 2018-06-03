#!/bin/sh

NORMAL="\\033[0;39m"         # Standard console grey
SUCCESS="\\033[1;32m"        # Success is green
WARNING="\\033[1;33m"        # Warnings are yellow
FAILURE="\\033[1;31m"        # Failures are red
INFO="\\033[1;36m"           # Information is light cyan
BRACKET="\\033[1;34m"        # Brackets are blue

ramt=$(cat /proc/meminfo | grep MemTotal | awk '{print $2}')
let ramt=ramt/1024
ramf=$(cat /proc/meminfo | grep MemFree  | awk '{print $2}')
let ramf=ramf/1024

echo "             _                    "
echo -n "            :_;                   "
echo "  $(cat /proc/cpuinfo | grep -i 'Hardware' | awk '{print $1": "$3" "$4}')"
echo -n ".-..-. .--. .-..---.  .--.   .--. "
echo "  $(cat /proc/cpuinfo | grep -i 'Model' | awk '{print $1": "$4}')"
echo -n ": \`; :' .; :: :: .; \`' .; ; '  ..'"
#echo -e "  RAM: ${ramt}MB\\tFREE: ${ramf}MB"
printf "  RAM:%06sMB FREE:%06sMB\n" ${ramt}  ${ramf}
echo -n "\`.__.'\`.__.':_;: ._.'\`.__,_;\`.__.'"
#echo -e "  ROM: $(df -h | grep root | awk '{print $2"B"}')\\t\\tFREE: $(df -h | grep root | awk '{print $4"B"}')"
printf "  ROM:%08s FREE:%08s\n" $(df -h | grep root | awk '{print $2"B"}') $(df -h | grep root | awk '{print $4"B"}')
echo -n "               : :                "
echo -e "  ROOT: ${SUCCESS}$(mount | grep -v '^rootfs' | grep root | awk '{print $5}')${NORMAL}"
echo -n "               :_;                "
echo "  IP: $(ifconfig eth0 | grep "inet addr" | cut -d ":" -f2 | cut -d " " -f1)"

