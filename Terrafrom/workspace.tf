resource "aws_instance" "webserver" {
  ami = var.amiid

  instance_type = (
    terraform.workspace == "prod" ? "m7i-flex.large" :
    terraform.workspace == "uat"  ? "c7i-flex.large" :
    "t3.micro"
  )

  key_name = var.keypair

  tags = {
    Name = var.servername
  }

  root_block_device {
    volume_size = var.volume
  }
}
