SUMMARY = "Multimedia files"
DESCRIPTION = "Various audio/video files."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

SRC_URI = " \
	file://sample.wav \
	file://sample.mp3 \
"

S = "${WORKDIR}"

do_install() {
	mkdir -p ${D}/home/root/multimedia/
	cp ${S}/sample.wav ${D}/home/root/multimedia/
	cp ${S}/sample.mp3 ${D}/home/root/multimedia/
}

FILES_${PN} = " \
	/home/root/multimedia/* \
"
