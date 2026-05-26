FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://boot.env"

do_configure:append() {
    cat ${WORKDIR}/boot.env >> ${B}/.config
}
