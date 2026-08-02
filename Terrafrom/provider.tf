provider "aws" {

  region = "us-east-1"

}

resource "aws_instance" "webserver" {
  tags = {
    Name = var.servername
  }

  ami           = var.amiid
  instance_type = var.itype
  key_name      = var.keypair
  root_block_device {
    volume_size =var.volume
  }


}

variable "servername" {
  type    = string
  default = "Test"
}

variable "amiid" {
  type    = string
  default = "ami-0b6d9d3d33ba97d99"
}

variable "itype" {
  type    = string
  default = "t3.micro"
}
variable "keypair" {
  type    = string
  default = "masterslave"
}

variable "volume" {
  type = number
  default = 10
}
