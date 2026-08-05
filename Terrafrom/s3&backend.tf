resource "aws_s3_bucket" "mybucket" {
  bucket = "sivasai-s3-backend-2379"
}
resource "aws_s3_bucket_versioning" "version" {
  bucket = aws_s3_bucket.mybucket.id

  versioning_configuration {
    status = "Enabled"
  }
}

terraform {
  backend "s3" {

    bucket       = "sivasai-s3-backend-2379"
    key          = "test/terraform.tfstate"
    region       = "us-east-1"
    use_lockfile = true
  }
}
