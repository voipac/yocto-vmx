#!/bin/sh

LAYERS_DIR=./sources/base/conf/
LAYER_VOIPAC_STRING="BBLAYERS += \"\${BSPDIR}/sources/meta-freescale-vmx\""

if [ -w ${LAYERS_DIR}/bblayers.conf ]
then
	grep "${LAYER_VOIPAC_STRING}" "${LAYERS_DIR}/bblayers.conf" > /dev/null
	TMPRETVAL=$(echo $?)
	TMPPRINT=""

	if [ ${TMPRETVAL} -eq 0 ]
	then
		TMPPRINT="already present"
	fi

	if [ ${TMPRETVAL} -eq 1 ]
	then
		echo "${LAYER_VOIPAC_STRING}" >> ${LAYERS_DIR}/bblayers.conf
		TMPPRINT="added"
	fi

	echo "Layer meta-freescale-vmx ${TMPPRINT}"
fi
