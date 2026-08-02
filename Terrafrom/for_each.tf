resource "aws_instance" "server" {
for_each = var.servers 
ami ="ami-0b6d9d3d33ba97d99"
instance_type =each.value.itype
root_block_device  {
volume_size = each.value.volume
}
tags = {
Name = "${each.key}-server"
Env  = each.value.env
}
}

variable "servers" {
  type =map(object( {
  itype =string
  volume = number
  env = string
}))
 default = {
   dev ={
     itype ="t3.micro"
     volume =8
     env = "dev"
   }
   uat = { 
     itype ="c7i-flex.large"
     volume = 10
     env  = "UAT"
   }
   prod = {
     itype ="m7i-flex.large"
     volume = 12
     env = "prod"
   }
 }
 }
