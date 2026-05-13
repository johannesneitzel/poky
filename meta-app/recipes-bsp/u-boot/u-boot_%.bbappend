FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0001-arm64-add-tftp-update-env.patch"

# TFTP firmware update defaults — override in local.conf or machine conf:
#   UBOOT_TFTP_SERVER_IP = "10.0.0.1"
#   UBOOT_BOARD_IP       = "10.0.0.10"
#   UBOOT_BOARD_NETMASK  = "255.255.0.0"
UBOOT_TFTP_SERVER_IP ?= "192.168.1.100"
UBOOT_BOARD_IP       ?= "192.168.1.10"
UBOOT_BOARD_NETMASK  ?= "255.255.255.0"

do_configure[vardeps] += "UBOOT_TFTP_SERVER_IP UBOOT_BOARD_IP UBOOT_BOARD_NETMASK"

do_configure:append() {
    sed -i \
        -e "s|@TFTP_SERVER_IP@|${UBOOT_TFTP_SERVER_IP}|g" \
        -e "s|@BOARD_IP@|${UBOOT_BOARD_IP}|g" \
        -e "s|@BOARD_NETMASK@|${UBOOT_BOARD_NETMASK}|g" \
        "${S}/include/configs/qemu-arm.h"
}
