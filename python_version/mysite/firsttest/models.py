from django.db import models

# Create your models here.
class search_result(models.Model):
    result_id = models.IntegerField(default=0)
    total_result_number = models.CharField(max_length=100)
    match_rate = models.CharField(max_length=100)
    doc_id = models.CharField(max_length=100)
    content = models.TextField(blank=True)

    def __str__(self):
        return self.title



